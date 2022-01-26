package madwhale.g82.instagram.model;

public class PostItem {

    String postImgUrl;
    String userName;
    String postText;
    int postLikeCount;
    boolean isUserLike;

    public PostItem(boolean isUserLike,int postLikeCount, String userName,String postImgUrl, String postText) {
        this.postImgUrl = postImgUrl;
        this.userName = userName;
        this.postText = postText;
        this.postLikeCount = postLikeCount;
        this.isUserLike = isUserLike;
    }

   // public String getPostImgUrl() {
       // return postImgUrl;
   // }

    public String getUserName() {
        return userName;
    }

    public String getPostText() {
        return postText;
    }

    public int getPostLikeCount() {
        return postLikeCount;
    }

    public boolean isUserLike() {
        return isUserLike;
    }
}
