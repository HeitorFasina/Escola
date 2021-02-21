3() {
x = int(input("Digite o número inicial: "))
y = int(input("Digite o número final: "))

def pares(x, y):
  for c in range(x, y):
    if c % 2 != 0:
      continue
    print(c)

  return

pares(x, y)
}
