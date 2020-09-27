#include <iostream>
#include <thread>
using namespace std;

// Read one character from the commandline:
void foo() 
{
    // Variable holding the character
    char inputValue;
    cout << "Enter the value : ";
    cin >> inputValue;
}

int main() {

    // Spawn new thread that calls foo()
    thread fooThread(foo);

    // This is your main loop:
    int i = 0;
    do {
        //do stuff
        i++;
    } while (i != 1000);

    return 0;
}
