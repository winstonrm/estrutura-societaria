# Prova Prática Java
No Banco XPTO, para o cálculo do comprometimento financeiro de uma empresa, leva-se em
conta o total de bens imóveis desta empresa e de seus sócios. Escreva um método (e todas as
classes adicionais) para retornar o total do comprometimento financeiro de uma empresa,
passando como parâmetro a sua estrutura societária.

# Requisitos de Negócio:
- A estrutura societária de uma empresa é sempre composta por ao menos uma pessoa
física e pode ser composta por mais pessoas físicas e/ou jurídicas.
Pode haver ciclo societário, ou seja, a empresa A pode ser sócia da empresa B e a empresa A
- Pode vir a ser sócia da empresa A. Inclusive, a empresa A pode vir a ser sócia dela
mesma. Além disso, qualquer pessoa física ou jurídica pode ser sócia de mais de uma
empresa.
- A contabilização dos bens imóveis de uma pessoa (física ou jurídica) só deve ocorrer uma
única vez.

# Requisitos Técnicos:
- Crie seu projeto utilizando algum gerenciador de dependências (ex: Maven) de maneira a
independer de qualquer IDE.
- Valide a consistência de todas suas entradas (ex: CPF/CNPJ) e instancie todos seus objetos
em estado consistente.
- Verifique com muito cuidado se seu programa não corre o risco de entrar em loop infinito
para nenhum caso de estrutura societária. Este será um dos principais pontos avaliados.

# Sugestões:
- Escreva seu código utilizando todos os padrões no qual você possui conhecimento.
- Caso queira, pode utilizar a biblioteca Lombok para os seus POJOs.
- Comente os trechos de código quando achar conveniente. Lembre-se que futuramente,
outras pessoas poderão dar manutenção nele.
- Seu código será avaliado pela funcionalidade, clareza e otimização.
