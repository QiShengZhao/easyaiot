<script setup lang="ts" name="InfraDruid">
import { ref } from 'vue'
import { IFrame } from '@/components/iFrame'

// 同源路径：由 WEB nginx 反代到 system Druid，避免依赖编译期 VITE_GLOB_BASE_URL（网关常缺 /druid 路由导致 404）
const src = ref('/druid/index.html')
</script>

<template>
  <div>
    <IFrame :src="src" />
  </div>
</template>
