class AuthenticationManager {

    private final int ttl;
    private final Map<String,Integer> tokenMap;

    public AuthenticationManager(int timeToLive) {        
        this.ttl = timeToLive;
        tokenMap = new ConcurrentHashMap<>();     
    }
        
    
    
    public void generate(String tokenId, int currentTime) {
        int expiryTime = currentTime + this.ttl;
        tokenMap.put(tokenId,expiryTime);
        
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId)){
           int expireTime = tokenMap.get(tokenId);
            if(currentTime<expireTime){
                tokenMap.put(tokenId,currentTime+ttl);
            }else{
                tokenMap.remove(tokenId);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int activeToken=0;


        for (Map.Entry<String, Integer> entry : tokenMap.entrySet()) {
            if (entry.getValue() > currentTime) {
                activeToken++;
            }
        }
            return activeToken;        
    }

}
/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */