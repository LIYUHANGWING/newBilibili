const Ws = require('ws');

((Ws) => {
    const server = new Ws.Server({port: 8082});

    const init = () => {
        bindEvent();
    }

    function bindEvent() {
        // server.on('connection', handleConnection);
        server.on('connection', handleConnection);
    }

    function handleConnection(ws) {
        ws.on('message', handleMessage)

    }

    function handleMessage(msg){
        server.clients.forEach((c) => {
            c.send(msg.toString());
        })
    }


    init();
})(Ws);
