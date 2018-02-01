#include <cstdlib>
#include <iomanip>
#include <fstream>
#include <cstdio>
#include <cstring>
#include <string>
#include <sstream>
#include <algorithm>
#include <utility>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <bitset>
#include <complex>
#include <map>
#include <set>
#include <cmath>
#include <queue>
#include <iostream>
using namespace std;

long double check(int k) ;
int n;
int maxAng = 360;
int halfAng = 180;
char given[1000][10];
int A[1000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    char read[100];
    cout.tie(0);
    int arg;
    scanf("%d", &arg);
    
    
    while (arg-- >0) {
        scanf("%d", &n);
        bool VALID = false;
        for (int i = 0; i < n; ++i) {
            scanf("%s %s", given[i], read);
            
            if (read[0] == '?') {
                A[i] = -1;
                VALID = given[i][0] == 'l' or given[i][0] == 'r';
            } else {
                int coorX = atoi(read);
                
                A[i] = coorX;
            }
        }
        
        if (VALID) {
            long double countLD = 0.0L;
            long double lowerBound = check(0);
            int output = 0;
            int input = 0;
            for (int phi = 1; phi < 360; ++phi) {
                long double addTo = check(phi);
                if (addTo < lowerBound) {
                    lowerBound = addTo;
                    output = phi;
                }
            }
            
            printf("%d\n", output);
        } else {
            int q=0;
            int err = 1;
            int m = 0;
            int h = 1e9;
            while (h > m + err) {
                int half = (m + h) / 2;
                long double firstPart = check(half-1);
                long double secondPart = check(half);
                if (check(half - 1) < check(half)) {
                    h = half;
                } else {
                    m = half;
                }
            }
            
            while (check(m)>check(m+1)) ++m;
            printf("%d\n", m);
        }
    }
    
    return 0;
}
long double check(int k)
{
    int phi = 0;
    long double coorX = 0.0L;
    long double coorY = 0.0L;
    
    
    for (int i = 0; i < n; ++i) {
        int x = A[i] == -1 ? k : A[i];
        if (given[i][0]=='f')
        {
            coorX = coorX + cos(M_PI*phi/180.0L)*x;
            coorY = coorY + sin(M_PI*phi/180.0L)*x;
        } else if (given[i][0]=='b') {
            
            coorX = coorX - cos(M_PI*phi/180.0L)*x;
            coorY = coorY - sin(M_PI*phi/180.0L)*x;
        } else if (given[i][0]=='l') phi = (phi + x)%360;
        
        else phi = (phi + 360-x)%360;
        
        
        
    }
    
    return coorX*coorX+coorY*coorY;
}