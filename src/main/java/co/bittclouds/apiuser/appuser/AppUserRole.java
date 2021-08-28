package co.bittclouds.apiuser.appuser;

public enum AppUserRole {

    USER(1),
    ADMIN(2);

    private int id;

    AppUserRole(int id){
        this.id = id;
    }

}
