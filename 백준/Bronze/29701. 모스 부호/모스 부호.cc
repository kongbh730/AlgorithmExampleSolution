#include <iostream>
#include <vector>
#include <map>

using namespace std;

void input_data(vector<string>& morse);
string find_answer(vector<string>& morse);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> morse;

	input_data(morse);
	cout << find_answer(morse) << "\n";

	return 0;
}

void input_data(vector<string>& morse) {
	int N, i;
	string temp;

	cin >> N;
	for (i = 0; i < N; i++) {
		cin >> temp;
		morse.push_back(temp);
	}

	return;
}

string find_answer(vector<string>& morse) {
    string ans = "";

    map<string, char> morse_code{
        {".-", 'A'},   {"-...", 'B'}, {"-.-.", 'C'}, {"-..", 'D'},  {".", 'E'},
        {"..-.", 'F'}, {"--.", 'G'},  {"....", 'H'}, {"..", 'I'},   {".---", 'J'},
        {"-.-", 'K'},  {".-..", 'L'}, {"--", 'M'},   {"-.", 'N'},   {"---", 'O'},
        {".--.", 'P'}, {"--.-", 'Q'}, {".-.", 'R'},  {"...", 'S'},  {"-", 'T'},
        {"..-", 'U'},  {"...-", 'V'}, {".--", 'W'},  {"-..-", 'X'}, {"-.--", 'Y'},
        {"--..", 'Z'},
        {".----", '1'}, {"..---", '2'}, {"...--", '3'}, {"....-", '4'}, {".....", '5'},
        {"-....", '6'}, {"--...", '7'}, {"---..", '8'}, {"----.", '9'}, {"-----", '0'},
        {"--..--", ','}, {".-.-.-", '.'}, {"..--..", '?'}, {"---...", ':'},
        {"-....-", '-'}, {".--.-.", '@'}
    };

    for (string code : morse) {
        ans += morse_code[code];
    }

    return ans;
}