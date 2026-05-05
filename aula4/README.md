---
marp: true
backgroundColor: black
color: white
---

# FP
## Programação Funcional

---

# Conteúdo do Módulo

- Introdução à Programação Funcional
- Funções de Primeira Classe e Ordem Superior
- Imutabilidade e Estado
- Funções Puras e Efeitos Colaterais
- Expressões Lambda e Arrow Functions
- Map, Filter e Reduce
- Recursividade vs. Iteração
- Composição de Funções (Currying e Pipelining)
- Feedback e revisão

---

# Por que Programação Funcional?

* **Previsibilidade:** Funções puras sempre retornam o mesmo resultado para os mesmos argumentos.
* **Concorrência:** Como os dados são imutáveis, é muito mais seguro executar código em paralelo.
* **Testabilidade:** Código modular e sem estado global é drasticamente mais fácil de testar.
* **Manutenibilidade:** Foco no "o quê" (declarativo) em vez do "como" (imperativo).

---

# Os 4 Pilares da PF

1. **Imutabilidade:** Uma vez criado, um dado não muda. Criamos novos dados a partir dos antigos.
2. **Funções Puras:** Não alteram nada fora delas (sem efeitos colaterais).
3. **Funções de Primeira Classe:** Funções são tratadas como variáveis (podem ser passadas como argumento).
4. **Transparência Referencial:** Uma chamada de função pode ser substituída pelo seu valor resultante sem mudar o comportamento do programa.

---

# Paradigma Imperativo vs. Declarativo


* **Imperativo (POO/Estruturado):** Foco nos passos e na mudança de estado. "Abra a geladeira, pegue o ovo, frite o ovo..."
* **Declarativo (Funcional):** Foco na lógica e na transformação de dados. "Eu quero um ovo frito."

---

# O que é uma Função Pura?

```javascript
// Impura (Depende de fator externo)
let bonus = 10;
const somaImpura = (a, b) => a + b + bonus;

// Pura (Resultado depende apenas dos parâmetros)
const somaPura = (a, b) => a + b;

---

# Imutabilidade na Prática
Em vez de alterar um array, geramos um novo:

```
const convidados = ["Neymar", "Messi"];

// Errado (Mutação)
convidados.push("Modric"); 

// Certo (Funcional)
const novosConvidados = [...convidados, "Modric"];
```

---

# Map, Filter e Reduce: As Ferramentas de Ouro

- Filter: Filtra elementos (Ex: Apenas convidados maiores de 18 anos).

- Map: Transforma elementos (Ex: Converter todos os nomes para MAIÚSCULO).

- Reduce: Agrega elementos (Ex: Somar o valor total da festa).