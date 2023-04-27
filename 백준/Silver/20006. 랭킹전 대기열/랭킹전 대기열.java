import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            if(rooms.size() == 0) {
                rooms.add(new Room(level, new User(level, id)));
            }else{
                int enter = -1;
                for (int j = 0; j < rooms.size(); j++) {
                    if(rooms.get(j).isEnter(level)){
                        enter = j;
                        break;
                    }
                }
                if(enter != -1) rooms.get(enter).enterUser(new User(level, id));
                else rooms.add(new Room(level, new User(level, id)));
            }
        }
        for (Room room: rooms) {
            if(room.getCount() == M) room.setIsStarted();
        }
        for (Room room:rooms) {
            if(room.isStarted) System.out.println("Started!");
            else System.out.println("Waiting!");
            Collections.sort(room.users, ((e1, e2) -> e1.id.compareTo(e2.id)));
            for (User user: room.users) {
                System.out.println(user.level + " " + user.id);
            }
        }
    }

    static class User{
        int level; String id;
        public User(int level, String id) {
            this.level = level;
            this.id = id;
        }
    }

    static class Room{
        int count, level;
        boolean isStarted;
        List<User> users = new ArrayList<>();

        public Room(int level, User user){
            this.level = level;
            this.count = 1;
            users.add(user);
        }
        public boolean isEnter(int level){
            if(this.count < M && !isStarted && level >= this.level - 10 && level <= this.level + 10) return true;
            return false;
        }
        public void enterUser(User user){
            this.count++;
            users.add(user);
        }
        public int getCount(){
            return this.count;
        }
        public void setIsStarted(){
            this.isStarted = true;
        }
    }
}