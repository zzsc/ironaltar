package pl.ironaltar.domain;

import javax.persistence.*;

/**
 * Created by szzc on 02.02.17.
 */
    @Entity
    @Table(name = "role")
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="role_id")
        private int id;
        @Column(name="role")
        private String role;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }




}
