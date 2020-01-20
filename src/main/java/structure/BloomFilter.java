package structure;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.Random;

/**
 * Created by Jun on 2018/3/12.
 */
public class BloomFilter<E> {
    private BitSet bitset;

    private int bitSetSize;
    private int numHashFunc;

    public BloomFilter(int size, int num){
        this.bitSetSize = size;
        this.numHashFunc = num;
        bitset = new BitSet(bitSetSize);
    }

    /*
        根据期望失误率和预测元素个数，计算最优bitSet大小和哈希函数个数
        因为int类型范围限制，在万分之一的失误率下，期望输入数据最大为1.1亿个
        e.g: new BloomFilter<String>(0.0001, 1.1E8)
     */
    public BloomFilter(double falsePositiveProbability, double expectedNumberOfElements) {
        this((int) (Math.ceil(-Math.log(falsePositiveProbability) * expectedNumberOfElements / Math.pow(Math.log(2), 2))),
                (int) (Math.ceil(Math.log(2) * (-Math.log(falsePositiveProbability) * expectedNumberOfElements / Math.pow(Math.log(2), 2)) / expectedNumberOfElements)));
    }

    public void add(E obj){
        int[] indexes = getHashIndexes(obj);
        for(int index : indexes)
            bitset.set(index);
    }

    public boolean contains(E obj){
        int[] indexes = getHashIndexes(obj);
        for(int index : indexes)
            if(!bitset.get(index))
                return false;
        return true;
    }

    private int[] getHashIndexes(E obj){
        int[] indexes = new int[numHashFunc];
        long seed = 0;
        byte[] digest;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(obj.toString().getBytes());
            digest = md.digest();
            for(int i=0;i<6;i++)
                seed = seed^(((long)(digest[i] & 0xFF)) << (8*i));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Random gen = new Random(seed);
        for(int i=0;i<numHashFunc;i++)
            indexes[i] = gen.nextInt(bitSetSize);
        return indexes;
    }

    // 布隆过滤器真实失误率
    public double getFalsePositiveProbability(int numberOfElements) {
        // (1 - e^(-k * n / m)) ^ k
        return Math.pow((1 - Math.exp(-numHashFunc * numberOfElements
                / (double) bitSetSize)), numHashFunc);
    }
}
