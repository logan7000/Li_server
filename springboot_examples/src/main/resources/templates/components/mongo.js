// my-component.js
export default {
    data() {
        return { count: 0 }
    },
    mounted(){
        console.log(axios);
    },
    template: `<div>count is {{ count }}</div>`
}
