package project.repository;

public interface iRepository <T> {
    T create();
    void read();
    void update();
    void delete();
}