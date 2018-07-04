package test_7_4;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainDriver {
	List<Block> blockchain = new ArrayList<Block>();
	public static void main(String[] args) throws NoSuchAlgorithmException{
		//GenesisBlock
		String[] transactions = {"Hosang sent 1k Bitcoins to Zuckerberg."};
		Block genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
		System.out.println("Genesis Block Hash :" + genesisBlock.getBlockHash());
		//Second Block
		String[] secondTransactions = {"Zuckerberg sent 500 Bitcoins to Hosang."};
		Block secondBlock = new Block(new BlockHeader(genesisBlock.getBlockHash().getBytes(), secondTransactions), secondTransactions);
	    System.out.println("Second Block Hash : " + secondBlock.getBlockHash());
		//Third Block
	    String[] thirdTransactions = {"Hosang sent 500 Bitcoins to Moon."}; 
	    Block thirdBlock = new Block(new BlockHeader(secondBlock.getBlockHash().getBytes(), thirdTransactions), thirdTransactions);
		System.out.println("Third Block Hash : " + thirdBlock.getBlockHash());
	    //Transaction Forgery
		//transactions[0] = "Hosang sent 10k Bitcoins to Zuckerberg.";
		//genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
		//System.out.println("Block Hash : " + genesisBlock.getBlockHash());
	}
}
