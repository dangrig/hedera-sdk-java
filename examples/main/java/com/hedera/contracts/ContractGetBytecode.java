package com.hedera.contracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hedera.sdk.common.HederaPrecheckResult;
import com.hedera.sdk.contract.HederaContract;

public final class ContractGetBytecode {
	public static boolean getByteCode(HederaContract contract) throws Exception {
		final Logger logger = LoggerFactory.getLogger(ContractGetBytecode.class);

		logger.info("");
		logger.info("CONTRACT GET BYTECODE");
		logger.info("");

		// run a get bytecode
		byte[] bytecode = contract.getByteCode();
		if (bytecode != null) {
			// it was successful, print it
			logger.info("===>Got bytecode=" + bytecode.toString());
			return true;
		} else if (contract.getPrecheckResult() == HederaPrecheckResult.BUSY) {
			logger.info("system busy, try again later");
			return false;
		} else {
			// an error occurred
			logger.info("===>Getting bytecode - precheck ERROR");
			logger.info(contract.getPrecheckResult().toString());
			return false;
		}
	}

}
