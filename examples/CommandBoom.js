//这里可以使用 rhino 对于的 interface 的简单写法
var commandCallback=new _RMPE.command.CommandInstance.Callback({
	"execute":function(server,sender,args){
		//TODO
		Level.explode(sender.posX,sender.posY,sender.posZ,10);
	}
});

// 参数: 指令名, 用法, 回调
var commandIns=new _RMPE.command.CommandInstance("boom","/boom",commandCallback);

//指令须在存档中加载 否则会报错
_RMPE.broadcast.FMLEventHandler.getInstance().registerCallback("serverStarting",new _RMPE.broadcast.FMLEventHandler.FMLEventCallback({
	"call":function(event){
		_RMPE.command.CommandManager.getInstance().register(commandIns);
	}
}));
