export default {
    data() {
        return {
            x:20,
            y:40
        };
    },
    template: `<div>x : {{x}}</div>
    <div>y : <span v-text="y"></span></div>`
}