function amtCheck(amount){
    var exp = /^([1-9][\d]{0,10}|0)(\.[\d]{1,2})?$/;
    if(exp.test(amount)){
		return true;
    }else{
		return false;
    }
}