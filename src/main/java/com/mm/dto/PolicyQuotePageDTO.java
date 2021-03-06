package com.mm.dto;

import java.util.List;

import MMTestCase.SmokeTestCase;

public class PolicyQuotePageDTO {

	public String policyactionvalue;
	public String saveAsPolicyDDLValue;
	public String secondSaveAsPolicyDDLValue;
	public String valueOfPolicyActionCopy;
	public String quotePhaseValue;
	public String riskType;
	public String binderForm;
	public String saveAsPolicyValue;
	public String saveAsPolicyValueRenewal;
	public String saveAsPolicyValueOfficial;
	public String policyActionValue;
	public String productNotifyValue;
	public List <String> coverages;
	public List <String> phases;

	public PolicyQuotePageDTO() throws IllegalArgumentException, IllegalAccessException, SecurityException{


		for (int iFC=0; iFC < PolicyQuotePageDTO.class.getFields().length; iFC++) 
		{
			if (SmokeTestCase.testDataMap.containsKey(PolicyQuotePageDTO.class.getFields()[iFC].getName().toLowerCase()))
			{
				if(PolicyQuotePageDTO.class.getFields()[iFC].getType().toString().toLowerCase().contains("java.util.list"))
				{
					try{
						PolicyQuotePageDTO.class.getFields()[iFC].set(this, SmokeTestCase.testDataMap.get(PolicyQuotePageDTO.class.getFields()[iFC].getName().toLowerCase()));

					}catch(Exception e){
						e.printStackTrace();
						System.out.println(SmokeTestCase.testDataMap.get(PolicyQuotePageDTO.class.getFields()[iFC].getName()));
					}

				}else				
				{
					try{
						PolicyQuotePageDTO.class.getFields()[iFC].set(this, SmokeTestCase.testDataMap.get(PolicyQuotePageDTO.class.getFields()[iFC].getName().toLowerCase()).get(0));

					}catch(Exception e){
						e.printStackTrace();
						System.out.println(SmokeTestCase.testDataMap.get(PolicyQuotePageDTO.class.getFields()[iFC].getName()));
					}
				}
			}
		}
	}
}
