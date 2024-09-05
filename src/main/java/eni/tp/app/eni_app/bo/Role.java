package eni.tp.app.eni_app.bo;

public class Role {

    private String role;
    private Integer isAdmin;

    public Role() {}

    public Role(String role, Integer isAdmin) {
        this.role = role;
        this.isAdmin = isAdmin;
    }

    public String getRole() {
        return role;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}
