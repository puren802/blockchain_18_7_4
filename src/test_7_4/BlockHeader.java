package test_7_4;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BlockHeader {
	//6가지 메타 데이터를 담고있다
	private int version; //SW또는 프로토콜 버전
	private byte[] previousBlockHash; //이전블록의 헤더에 대한 해쉬값
	private int merkleRootHash; //머클트리의 루트에 대한 해쉬값
	private int timestamp; //블록 생성 시각
	private int difficultyTarget; //POW의 난이도목표
	private int nonce; //POW에서 사용되는 카운터
	
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
