# EasyAIoT Boot3 全业务回归清单

基线：Spring Boot 3.5.16 + JDK 21；入口 `http://127.0.0.1:8888`  
账号：`admin` / `admin123`，租户 Admin-IoT（需传租户标识）

自动化冒烟：`.scripts/docker/regression-smoke.ps1`

## A. 基础设施（中间件）

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| A1 | postgres-server | healthy | |
| A2 | redis-server | healthy | |
| A3 | nacos-server | healthy；`8848/nacos` 可访问 | |
| A4 | kafka-server | healthy | |
| A5 | minio-server | healthy | |
| A6 | milvus-server | healthy | |
| A7 | emqx-server | healthy | |
| A8 | tdengine-server | healthy | |
| A9 | srs-server | healthy（Windows Docker Desktop 下 `network_mode=host`，宿主机勿直连 1985；以容器健康检查/ docker exec 为准） | |
| A10 | zlmediakit-server | healthy；`6080` API 可用 | |
| A11 | nodered-server | healthy | |
| A12 | fuxa-server | healthy | |

## B. DEVICE 管控服务

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| B1 | iot-gateway | healthy；`48080` | |
| B2 | iot-system | healthy | |
| B3 | iot-infra | healthy | |
| B4 | iot-device | healthy | |
| B5 | iot-file | healthy | |
| B6 | iot-message | healthy | |
| B7 | iot-dataset | healthy | |
| B8 | iot-node | healthy | |
| B9 | iot-sink | healthy | |
| B10 | iot-tdengine | healthy | |
| B11 | iot-visualize | healthy | |
| B12 | iot-gb28181 | healthy / Up | |
| B13 | Druid | `48080/druid/index.html` → 200 | |
| B14 | WEB 同源 Druid | `8888/druid/` → 200 | |

## C. 前端与外围

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| C1 | web-service | healthy；`8888/` → 200 | |
| C2 | app-service | healthy | |
| C3 | visualize-service | healthy | |
| C4 | ai-service | healthy；`5000/actuator/health` → 200 | |
| C5 | video-service | healthy；`6000/actuator/health` → 200 | |
| C6 | easyaiot-node-agent | healthy / Up | |

## D. 登录与租户（手工）

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| D1 | 打开登录页 | 可选租户 Admin-IoT | |
| D2 | 登录 admin/admin123 | 进入控制台，不卡在登录页 | |
| D3 | 刷新保持会话 | Token/租户头仍有效 | |
| D4 | 系统管理菜单 | 用户/角色/菜单可打开 | |

## E. 设备与接入（手工/有环境时）

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| E1 | 产品管理列表 | 接口成功、列表可渲染 | |
| E2 | 设备列表/详情 | 接口成功 | |
| E3 | MQTT/EMQX 连通 | Broker 在线，可订阅演示主题 | |
| E4 | 文件上传 MinIO | 上传成功并可下载 | |

## F. 媒体与视频（手工/有摄像头时）

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| F1 | ZLM `getServerConfig` | code=0 | |
| F2 | SRS API `/api/v1/versions` | 容器内 200 / healthcheck 通过 | |
| F3 | VIDEO 服务注册 Nacos | video-server 在线 | |
| F4 | GB28181 / 直播预览 | 有流时可播 | |
| F5 | 推流转发/算法任务页 | 页面可开，无 5xx | |

## G. AI 能力（手工/有模型时）

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| G1 | AI health | success | |
| G2 | SAM 预热 | 日志 stage/预热完成 | |
| G3 | 检测/分割演示 | 有样例图时可出结果 | |

## H. 可视化与规则

| # | 项 | 期望 | 结果 |
|---|----|------|------|
| H1 | 可视化项目列表 | 可打开 | |
| H2 | GoView/大屏预览 | 可预览 | |
| H3 | Node-RED 编辑器 | `1880` 可开 | |
| H4 | FUXA | `1881` 可开 | |

## 通过标准

- **P0（必须）**：A 全部 healthy（ZLM 含在内）、B1–B14、C1–C5、D1–D2
- **P1（建议）**：E/F/G/H 在具备外设/样例数据时执行
- 自动化脚本覆盖 P0 中可脚本化的健康与 HTTP 探针；登录与业务页需人工勾选
