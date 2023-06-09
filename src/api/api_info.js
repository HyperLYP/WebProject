// home模块的请求接口
import request from '@/api/request';
// 首先导入封装好的axios
const api_info = {
  getStuList(currentPage, pageSize) {
    return request({
      method: 'GET',
      url: '/sys/stu/list',
      params: {
        pageNum:currentPage,
        pageSize:pageSize,
      }
    });
  },
  addStu(stu) {
    return request({
      method: 'post',
      url: '/sys/stu/add',
      data: stu,
    })
  },
  editStu(stu) {
    console.log('------修改的数据 '+JSON.stringify(stu));
    return request({
      method: 'post',
      url: '/sys/stu/edit',
      data: stu,
    })
  },
  deleteStu(stu) {
    return request({
      method: 'post',
      url: '/sys/stu/delete',
      data: stu,
    })
  },
  getCountByMajor() {
    return request({
      method: 'get',
      url: '/sys/stu/echarsInfo'
    })
  }
};
export default api_info;
