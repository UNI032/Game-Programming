# include <iostream>

using namespace std;
void print(string map[][8]);

int main()
{
    string map[8][8] = { 
        {"# ", "# ", "# ", "# ", "# ", "# ", "# ", "# "}, 
        {"# ", "G ", "  ", "# ", "# ", "# ", "  ", "# "},
        {"# ", "  ", "  ", "  ", "# ", "  ", "  ", "# "},
        {"# ", "# ", "# ", "  ", "# ", "  ", "# ", "# "},
        {"# ", "  ", "  ", "  ", "# ", "  ", "  ", "# "}, 
        {"# ", "  ", "# ", "# ", "# ", "# ", "  ", "# "}, 
        {"# ", "  ", "  ", "  ", "  ", "  ", "  ", "# "}, 
        {"# ", "# ", "S ", "# ", "# ", "# ", "# ", "# "}
    };
    print(map);
    printf("Game start! \n");
    int win = 0;
    int i = 7, y = 2;
    while (win != 1)
    {
        printf("Enter to move       ");
        char move, location;
        cin >> move;
        switch (tolower(move))
        {
        case 'n':
            i--;
            if (map[i][y].compare("# ") == 0 || map[i][y].compare("D ") == 0)
            {
                map[i][y] = "D ";
                map[i + 1][y] = "  ";
                cout << "You died" << endl;
                i = 7, y = 2;
                map[i][y] = "S";
            }
            else if ((map[i][y].compare("G ")) == 0)
            {
                cout << "You Win!!!" << endl;
                win = 1;
            }
            else
            {
                map[i][y] = "A ";
                map[i + 1][y] = "  ";
            }        
            break;

        case 's':
            i++;
            if ((map[i][y].compare("# ")) == 0 || (map[i][y].compare("D ")) == 0)
            {
                map[i][y] = "D ";
                map[i - 1][y] = "  ";
                cout << "You died" << endl;
                i = 7, y = 2;
                map[i][y] = "S ";
            }
            else if ((map[i][y].compare("G ")) == 0)
            {
                cout << "You Win!!!" << endl;
                win = 1;
            }
            else
            {
                map[i][y] = "A ";
                map[i - 1][y] = "  ";
            }
            break;

        case 'w':
            y--;
            if ((map[i][y].compare("# ")) == 0 || (map[i][y].compare("D ")) == 0)
            {
                map[i][y] = "D ";
                map[i][y + 1] = "  ";
                cout << "You died" << endl;
                i = 7, y = 2;
                map[i][y] = "S ";
            }
            else if ((map[i][y].compare("G ")) == 0)
            {
                cout << "You Win!!!" << endl;
                win = 1;
            }
            else
            {
                map[i][y] = "A ";
                map[i][y + 1] = "  ";
            }
            break;

        case 'e':
            y++;
            if ((map[i][y].compare("# ")) == 0 || (map[i][y].compare("D ")) == 0)
            {
                map[i][y] = "D ";
                map[i][y - 1] = "  ";
                cout << "You died" << endl;
                i = 7, y = 2;
                map[i][y] = "S ";
            }
            else if ((map[i][y].compare("G ")) == 0)
            {
                cout << "You Win!!!" << endl;
                win = 1;
            }
            else
            {
                map[i][y] = "A ";
                map[i][y - 1] = "  ";
            }
            break;

        case 'q':
            win = 1;
            cout << "You quit the adventure" << endl;
            break;

        default:
            cout << "Wrong direction" << endl;
        }
        print(map);
    }
    cout << endl << "Bye!";
}

void print(string map[][8])
{
    int y = 0;
    for (int i = 0; i < 8; i++)
    {
        cout << endl;
        for (y = 0; y < 8; y++)
            cout << map[i][y];
    }
    cout << endl;
}

