/*
**这是rmpescript的前置脚本，需要运行的脚本需要经过这个包装才可以使用
**
**
*/

/* FastImportPackage function */
//_RMPE=(function(){})
__=(function(){});
__.import=function(args,ptn) {
          for (var i in args)
              try {
                  Object.defineProperty(this,""+ptn+String(args[i]).split(".").pop().replace(/]/,""),{value:(args[i]), writable:false,enumerable:false,configurable:false});
              } catch (err) {return err;};
          return true;
        };
__.import(
	pro.npofsi.rmpescript.RMPE,
	pro.npofsi.rmpescript.modpe.Level,
	pro.npofsi.rmpescript.modpe.ModPE,
	pro.npofsi.rmpescript.modpe.Hooks,
	pro.npofsi.rmpescript.broadcast.ForgeEventHandler,
	"");

//打包替换部分

//SPLIT//