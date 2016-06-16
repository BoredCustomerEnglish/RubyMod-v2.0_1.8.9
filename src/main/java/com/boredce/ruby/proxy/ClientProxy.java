package com.boredce.ruby.proxy;

import com.boredce.ruby.init.RubyBlocks;
import com.boredce.ruby.init.RubyEntities;
import com.boredce.ruby.init.RubyItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders()
	{
		RubyItems.registerRenders();
		RubyBlocks.registerRenders();
		RubyEntities.registerRenders();
	}
}
