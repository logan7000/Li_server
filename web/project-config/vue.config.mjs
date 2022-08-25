//const {defineConfig} = require('@vue/cli-service')
import {defineConfig} from "@vue/cli-service";


/**
 *
 * @type DevServerConfiguration
 */
const devServer = {
    port: 3000, proxy: {
        '/api': {
            target: 'localhost:8080',
            ws: true,
            changeOrigin: true
        }, // 做一个实例
        //'/foo': {
        //    target: 'localhost:8081'
        //}
    }
};

export default defineConfig({
    devServer: devServer, transpileDependencies: true
})
