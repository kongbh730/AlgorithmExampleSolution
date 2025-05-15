import java.util.Scanner;
import java.util.*;


public class Main {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            node.isEnd = true;
        }

        boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (!node.children.containsKey(ch)) return false;
                node = node.children.get(ch);
            }
            return true;
        }
    }

    //static Trie 자료구조1 : 문자열 목록 저장
    static Trie trie = new Trie();

    //static 자료구조2 : 접두어 목록 저장
    static List<String> checkList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData() {
        int N, M;
        int i;

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        for(i = 0; i < N; i++) {
            String str = sc.nextLine();
            trie.insert(str);  // 문자열 목록 삽입
        }
        for(i = 0; i < M; i++) {
            String prefix = sc.nextLine();
            checkList.add(prefix);  // 접두어 목록 저장
        }
    }

    public static int findAnswer() {
        int answer = 0;

        for(String prefix : checkList) {
            if(trie.startsWith(prefix)) {
                //System.out.println(prefix + "는 접두어");
                answer++;
            }
        }

        return answer;
    }
}
