import pkg from '../../package.json'
import type { GlobEnvConfig } from '@/types/config'

import { warn } from '@/utils/log'

export function getCommonStoragePrefix() {
  const { VITE_GLOB_APP_SHORT_NAME } = getAppEnvConfig()
  return `${VITE_GLOB_APP_SHORT_NAME}__${getEnv()}`.toUpperCase()
}

// Generate cache key according to version
export function getStorageShortName() {
  return `${getCommonStoragePrefix()}${`__${pkg.version}`}__`.toUpperCase()
}

function getProductionConfigKey(shortName?: string) {
  return `__PRODUCTION__${shortName || '__APP'}__CONF__`.toUpperCase().replace(/\s/g, '')
}

/**
 * 生产环境优先读 index.html 注入的 _app.config.js（可运行时覆盖），
 * 开发环境读 Vite 注入的 import.meta.env。
 */
export function getAppEnvConfig() {
  const metaEnv = import.meta.env as unknown as GlobEnvConfig
  let ENV = metaEnv

  if (import.meta.env.PROD && typeof window !== 'undefined') {
    const keyFromMeta = getProductionConfigKey(metaEnv.VITE_GLOB_APP_SHORT_NAME)
    const runtimeConf =
      (window as any)[keyFromMeta]
      || (window as any).__PRODUCTION____APP__CONF__
      || (window as any).__PRODUCTION__IOT_ADMIN__CONF__
    if (runtimeConf)
      ENV = { ...metaEnv, ...runtimeConf } as GlobEnvConfig
  }

  const {
    VITE_GLOB_APP_TITLE,
    VITE_GLOB_BASE_URL,
    VITE_GLOB_API_URL,
    VITE_GLOB_APP_SHORT_NAME,
    VITE_GLOB_API_URL_PREFIX,
    VITE_GLOB_UPLOAD_URL,
    VITE_GLOB_APP_TENANT_ENABLE,
    VITE_GLOB_APP_CAPTCHA_ENABLE,
  } = ENV

  if (VITE_GLOB_APP_SHORT_NAME && !/^[a-zA-Z\_]*$/.test(VITE_GLOB_APP_SHORT_NAME)) {
    warn(
      'VITE_GLOB_APP_SHORT_NAME Variables can only be characters/underscores, please modify in the environment variables and re-running.',
    )
  }

  return {
    VITE_GLOB_APP_TITLE,
    VITE_GLOB_BASE_URL,
    VITE_GLOB_API_URL,
    VITE_GLOB_APP_SHORT_NAME,
    VITE_GLOB_API_URL_PREFIX,
    VITE_GLOB_UPLOAD_URL,
    VITE_GLOB_APP_TENANT_ENABLE,
    VITE_GLOB_APP_CAPTCHA_ENABLE,
  }
}

/**
 * @description: Development mode
 */
export const devMode = 'development'

/**
 * @description: Production mode
 */
export const prodMode = 'production'

/**
 * @description: Get environment variables
 */
export function getEnv(): string {
  return import.meta.env.MODE
}

/**
 * @description: Is it a development mode
 */
export function isDevMode(): boolean {
  return import.meta.env.DEV
}

/**
 * @description: Is it a production mode
 */
export function isProdMode(): boolean {
  return import.meta.env.PROD
}
