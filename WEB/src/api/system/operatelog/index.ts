import { defHttp } from '@/utils/http/axios'

/** 与后端 OperateLogRespVO 对齐（mzt-logapi 操作日志） */
export interface OperateLogVO {
  id: number
  traceId?: string
  userId: number
  userName?: string
  type: string
  subType: string
  bizId: number
  action: string
  extra?: string
  requestMethod?: string
  requestUrl?: string
  userIp?: string
  userAgent?: string
  createTime: Date
}

export interface OperateLogPageReqVO extends PageParam {
  userId?: number
  bizId?: number
  type?: string
  subType?: string
  action?: string
  createTime?: Date[]
}

// 查询操作日志列表
export function getOperateLogPage(params: OperateLogPageReqVO) {
  return defHttp.get({ url: '/system/operate-log/page', params })
}
// 导出操作日志
export function exportOperateLog(params: OperateLogPageReqVO) {
  return defHttp.download({ url: '/system/operate-log/export', params }, '操作日志.xls')
}
