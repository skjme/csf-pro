const path = require('path');
function resolve (dir) {
    return path.join(__dirname, dir)
}
module.exports = {
    lintOnSave: true,
    runtimeCompiler: true, // 使用构建版vue
    chainWebpack: (config)=>{
        config.resolve.alias
            .set('assets',resolve('src/assets'))
            .set('components',resolve('src/components'))
            //.set('easyui',resolve('src/easyui')) // 我这边是购买 了源代码，直接复制到src目录下使用

    }
}