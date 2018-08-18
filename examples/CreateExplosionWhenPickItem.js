//JavaImporter().importPackage();


_RMPE.broadcast.ForgeEventHandler.getInstance().registerCallback("pickupItem",new _RMPE.broadcast.ForgeEventHandler.EventCallback({
	call:(e)=>{
		Level.explode(e.getEntity().posX,e.getEntity().posY,e.getEntity().posZ,10)
	}
}));
