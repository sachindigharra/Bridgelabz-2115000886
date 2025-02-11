
class User {
    int userId;
    String name;
    int age;
    FriendList friends; // Nested linked list for friends
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new FriendList();
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Age: " + age + ", Friends: " + friends;
    }
}

class Friend {
    int friendId;
    Friend next;

    public Friend(int friendId) {
        this.friendId = friendId;
    }

    @Override
    public String toString() {
        return String.valueOf(friendId); //Simplified friend display
    }
}

class FriendList {
    Friend head;

    public void addFriend(int friendId) {
        Friend newFriend = new Friend(friendId);
        if (head == null) {
            head = newFriend;
            return;
        }
        Friend current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newFriend;
    }

    public void removeFriend(int friendId) {
        if (head == null) return;

        if (head.friendId == friendId) {
            head = head.next;
            return;
        }

        Friend current = head;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Friend current = head;
        while (current != null) {
            sb.append(current.friendId);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class SocialNetwork {
    User head;

    public void addConnection(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friends.addFriend(userId2);
            user2.friends.addFriend(userId1); // Connection is bidirectional
        }
    }

    public void removeConnection(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friends.removeFriend(userId2);
            user2.friends.removeFriend(userId1);
        }
    }

    public FriendList findMutualFriends(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        FriendList mutualFriends = new FriendList();

        if (user1 != null && user2 != null) {
            Friend current1 = user1.friends.head;
            while (current1 != null) {
                Friend current2 = user2.friends.head;
                while (current2 != null) {
                    if (current1.friendId == current2.friendId) {
                        mutualFriends.addFriend(current1.friendId);
                        break; // Found a mutual friend, no need to continue inner loop
                    }
                    current2 = current2.next;
                }
                current1 = current1.next;
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        User user = searchUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        }
    }

    public User searchUserById(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public User searchUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void countFriends(int userId) {
        User user = searchUserById(userId);
        if (user != null) {
            int count = 0;
            Friend current = user.friends.head;
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println(user.name + " has " + count + " friends.");
        }
    }

        public void addUser(User newUser) {
        if (head == null) {
            head = newUser;
            return;
        }
        User current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newUser;
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(new User(1, "Alice", 25));
        network.addUser(new User(2, "Bob", 30));
        network.addUser(new User(3, "Charlie", 28));

        network.addConnection(1, 2);
        network.addConnection(1, 3);
        network.addConnection(2, 3);

        network.displayFriends(1);
        network.displayFriends(2);
        network.displayFriends(3);

        FriendList mutual = network.findMutualFriends(1, 2);
        System.out.println("Mutual friends of Alice and Bob: " + mutual);

        network.removeConnection(1, 2);
        network.displayFriends(1);

        network.countFriends(1);
        network.countFriends(2);
        network.countFriends(3);


        User foundUser = network.searchUserByName("Bob");
        if(foundUser != null) {
            System.out.println("Found User by name: " + foundUser);
        }

         foundUser = network.searchUserById(3);
        if(foundUser != null) {
            System.out.println("Found User by ID: " + foundUser);
        }


    }
}