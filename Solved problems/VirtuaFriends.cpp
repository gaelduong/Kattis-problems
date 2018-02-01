int main() {
    
    int N, ans = 0, v;
    scanf("%d", &N);
    
    while (N--) {
        scanf("%d", &v);
        ++c[v];
        if (c[++v] > 0)
            --c[v];
        else	++ans;
    }
    
    printf("%d\n", ans);
    
    return 0;
}
