/**
 * Copyright (c) 2009 DITA2InDesign project (dita2indesign.sourceforge.net)  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at     http://www.apache.org/licenses/LICENSE-2.0  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License. 
 */
package net.sourceforge.dita4publishers.impl.bos;

import net.sourceforge.dita4publishers.api.bos.BosException;
import net.sourceforge.dita4publishers.api.bos.BosMember;
import net.sourceforge.dita4publishers.api.bos.BosVisitor;
import net.sourceforge.dita4publishers.api.bos.BoundedObjectSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Base class for BosVisitor implementations. Provides default BOS visiting method
 * that iterates over BOS members as a list.
 */
public abstract class BosVisitorBase implements BosVisitor {

	protected Log log = LogFactory.getLog(BosVisitorBase.class);
	protected BoundedObjectSet bos;
	protected BosMember rootMember;


	/**
	 * @param log 
	 * 
	 */
	public BosVisitorBase(Log log) {
		super();
		this.log = log;
	}
	
	/**
	 * 
	 */
	public BosVisitorBase() {
		super();
	}
	

	public void visit(BosMember member) throws BosException, Exception {
		log.warn("Fell through to visit(BosMember) method in BosVisitorBase visiting " + member.getClass().getName());
	}


	/* (non-Javadoc)
	 * @see com.reallysi.tools.dita.BosVisitor#visit(com.reallysi.tools.dita.BoundedObjectSet)
	 */
	public void visit(BoundedObjectSet bos)
			throws Exception, BosException {
		// By default, just iterate over the members as a flat list.
		this.bos = bos;
		this.rootMember = bos.getRoot();
		for (BosMember member : bos.getMembers()) {
			member.accept(this);
		}
		
	}



}