#include <stdio.h>

void print_math(int a, int b) {
    printf("Enter the first number: ");
    scanf("%d", &a);

    printf("Enter the second number: ");
    scanf("%d", &b);

    printf("Sum: %d\n", a + b);
    printf("Product: %d\n", a * b);

    if (b != 0) {
        printf("Quotient: %.2f\n", (double)a / b);
    } else {
        printf("Division by zero is undefined.\n");
    }
}

int main(void) {
    int a = 0;
    int b = 0;

    print_math(a, b);
    return 0;
}