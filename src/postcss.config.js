module.exports = {
    plugins: {
        'postcss-pxtorem': {
            rootValue: 37.5,
            //设置的所有属性设置都转换起效！
            propList: ['*']
        }
    }
}