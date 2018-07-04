package test_7_4;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BlockHeader {
	//6���� ��Ÿ �����͸� ����ִ�
	private int version; //SW�Ǵ� �������� ����
	private byte[] previousBlockHash; //��������� ����� ���� �ؽ���
	private int merkleRootHash; //��ŬƮ���� ��Ʈ�� ���� �ؽ���
	private int timestamp; //��� ���� �ð�
	private int difficultyTarget; //POW�� ���̵���ǥ
	private int nonce; //POW���� ���Ǵ� ī����
	
	public BlockHeader(byte[] previousBlockHash, Object[] transactions) {
		this.previousBlockHash = previousBlockHash;
		this.merkleRootHash = this.someMethod(transactions);
	}
	
	public byte[] toByteArray() {
		String tmpStr = "";
		if(previousBlockHash != null) {
			tmpStr += new String(previousBlockHash,0,previousBlockHash.length);
		}
		tmpStr += merkleRootHash;
		return tmpStr.getBytes(StandardCharsets.UTF_8);
	}
	private int someMethod(Object[] transactions) {
		return Arrays.hashCode(transactions);
	}
}
