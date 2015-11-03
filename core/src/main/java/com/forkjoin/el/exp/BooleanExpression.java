package com.forkjoin.el.exp;

import com.forkjoin.el.Expression;

public abstract class BooleanExpression implements Expression<Boolean> {
	public Boolean el(Object obj){
		return booleanEl(obj);
	}
	public abstract boolean booleanEl(Object obj);
}
