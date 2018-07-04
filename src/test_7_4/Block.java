package test_7_4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private int blockSize; //���ũ�� 
	private BlockHeader blockHeader; //������
	private int transactionCount; //�ŷ��� ��
	private Object[] transactions; //�ŷ����� �÷���
	
	public Block(BlockHeader blockHeader, Object[] transactions) {
		this.blockHeader = blockHeader;
		this.transactions = transactions;
	}
	
	//SHA-256�˰����� �̿��� ����ؽ� ���
	public String getBlockHash() throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] blockHash = messageDigest.digest(blockHeader.toString().getBytes());
		blockHash = messageDigest.digest(blockHash);
		return new String(blockHash,0,blockHash.length);
	}
}
