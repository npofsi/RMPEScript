pro.npofsi.rmpescript.broadcast.ForgeEventHandler.registerCallback("pickupItem",new pro.npofsi.rmpescript.broadcast.ForgeEventHandler.EntityItemPickupEventCallback({
	"call":function(event){
		var ent=event
		Level.explode(ent.posX,ent.posY,ent.posZ,10);
	}
}));