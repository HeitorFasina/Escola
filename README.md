#Python

1() {
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
 
 2() {
  vet = input("Digite suas habilidades: ").lower().split()

  hab = "coragem"

  def ver(vet, hab):
    print(hab in vet)

    return

  ver(vet, hab)
 }
 
 3() {
  anos = int(input("Digite quantos anos de estudo você tem: "))

  def exp(anos):
    if anos >= 0 and anos <= 1:
      print("Iniciante")
    elif anos >= 1 and anos <= 3:
      print("Intermediário")
    elif anos >= 3 and anos <= 6:
      print("Avançado")
    elif anos >= 7:
      print("Jedi Master")

    return

  exp(anos)
 }
