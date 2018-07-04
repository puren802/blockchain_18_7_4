package test_7_4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private int blockSize; //블록크기 
	private BlockHeader blockHeader; //블록헤더
	private int transactionCount; //거래의 수
	private Object[] transactions; //거래정보 컬렉션
	
	public Block(BlockHeader blockHeader, Object[] transactions) {
		this.blockHeader = blockHeader;
		this.transactions = transactions;
	}
	
	//SHA-256알고리즘을 이용한 블록해쉬 계산
	public String getBlockHash() throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] blockHash = messageDigest.digest(blockHeader.toString().getBytes());
		blockHash = messageDigest.digest(blockHash);
		return new String(blockHash,0,blockHash.length);
	}
}
