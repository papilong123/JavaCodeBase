package redis;

import redis.clients.jedis.Jedis;

class RedisMemoryOptima {

    public static Jedis jedis = new Jedis("localhost", 30379);

    public static void main(String[] args) {
        jedis.auth("111111");
        Long m1 = Long.valueOf(getMemory());
        insertData();
        Long m2 = Long.valueOf(getMemory());
        System.out.println(m2 - m1);
    }

    public static void insertData(){
        for(int i = 10000; i < 100000; i++){
            jedis.set("aa" + i, "aa" + i); //key和value长度都是7字节，且不是整数
        }
    }

    public static String getMemory(){
        String memoryAllLine = jedis.info("memory");
        String usedMemoryLine = memoryAllLine.split("\r\n")[1];
        String memory;
        memory = usedMemoryLine.substring(usedMemoryLine.indexOf(':') + 1);
        return memory;
    }
}
