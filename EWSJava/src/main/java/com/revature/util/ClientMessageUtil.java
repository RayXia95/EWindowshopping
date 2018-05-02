package com.revature.util;

import com.revature.ajax.ClientMessage;

public final class ClientMessageUtil {
	public static final ClientMessage REGISTRATION_SUCCESSFUL = new ClientMessage("REGISTRATION SUCCESSFUL");
	public static final ClientMessage SOMETHING_WRONG = new ClientMessage("SOMETHING WENT WRONG");
	public static final ClientMessage INVALID_LOGIN = new ClientMessage("INVALID LOGIN");
	public static final ClientMessage PURCHASE_SUCCESSFUL= new ClientMessage("PURCHASE SUCCESSFUL");
	public static final ClientMessage SELL_SUCCESSFUL= new ClientMessage("SELLING SUCCESSFUL");
	public static final ClientMessage UPDATE_SUCCESSFUL= new ClientMessage("UPDATE SUCCESSFUL");
}
