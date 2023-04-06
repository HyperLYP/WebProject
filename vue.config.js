const { defineConfig } = require('@vue/cli-service');
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  // 处理跨域
  devServer: {
    proxy: {
      '/api01': {
        target: 'https://apis.tianapi.com', //API服务器的地址
        changeOrigin: true,//是否跨域
        pathRewrite: {
          '^/api01': '',//路径重写，也就是说会修改最终请求的API路径:api只是去代替整体路径
        },
      },
    },
  },
});	