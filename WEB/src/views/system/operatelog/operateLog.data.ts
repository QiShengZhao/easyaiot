import { h } from 'vue'
import type { BasicColumn, FormSchema } from '@/components/Table'
import { useRender } from '@/components/Table'
import type { DescItem } from '@/components/Description/index'

export const columns: BasicColumn[] = [
  {
    title: '日志编号',
    dataIndex: 'id',
    width: 100,
  },
  {
    title: '操作模块',
    dataIndex: 'type',
    width: 160,
  },
  {
    title: '操作名',
    dataIndex: 'subType',
    width: 140,
  },
  {
    title: '业务编号',
    dataIndex: 'bizId',
    width: 100,
  },
  {
    title: '操作人',
    dataIndex: 'userName',
    width: 120,
  },
  {
    title: '操作明细',
    dataIndex: 'action',
    width: 280,
  },
  {
    title: '请求路径',
    dataIndex: 'requestUrl',
    width: 220,
  },
  {
    title: '操作时间',
    dataIndex: 'createTime',
    width: 180,
    customRender: ({ text }) => {
      return useRender.renderDate(text)
    },
  },
]

export const searchFormSchema: FormSchema[] = [
  {
    label: '操作模块',
    field: 'type',
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    label: '操作名',
    field: 'subType',
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    label: '操作明细',
    field: 'action',
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    label: '用户编号',
    field: 'userId',
    component: 'InputNumber',
    colProps: { span: 8 },
  },
  {
    label: '操作时间',
    field: 'createTime',
    component: 'RangePicker',
    componentProps: {
      showTime: true,
      format: 'YYYY-MM-DD HH:mm:ss',
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
    colProps: { span: 8 },
  },
]

const httpMethods = [
  { value: 'GET', color: '#108ee9' },
  { value: 'POST', color: '#2db7f5' },
  { value: 'PUT', color: 'warning' },
  { value: 'DELETE', color: '#f50' },
]

export const infoSchema: DescItem[] = [
  {
    field: 'type',
    label: '操作模块',
  },
  {
    field: 'subType',
    label: '操作名',
  },
  {
    field: 'bizId',
    label: '业务编号',
  },
  {
    field: 'userName',
    label: '操作人',
    render(_, data) {
      const { userName, userId } = data || {}
      return useRender.renderTags([userName || '-', `uid: ${userId ?? '-'}`])
    },
  },
  {
    field: 'action',
    label: '操作明细',
  },
  {
    field: 'extra',
    label: '拓展字段',
    show(data) {
      return !!(data && data.extra)
    },
  },
  {
    field: 'userIp',
    label: '请求 IP',
  },
  {
    field: 'createTime',
    label: '操作时间',
    render(value) {
      return useRender.renderDate(value)
    },
  },
  {
    field: 'requestUrl',
    label: '请求路径',
    render(_, data) {
      if (!data)
        return ''

      const { requestMethod, requestUrl } = data
      const method = (requestMethod || '').toUpperCase()
      const current = httpMethods.find(item => item.value === method)
      const methodTag = current ? useRender.renderTag(method, current.color) : method
      return h('span', {}, [methodTag, ' ', requestUrl || ''])
    },
  },
  {
    field: 'traceId',
    label: '链路追踪',
    show(data) {
      return !!(data && data.traceId)
    },
  },
  {
    field: 'userAgent',
    label: 'UserAgent',
  },
]
