# Para validação do loop
Quando uma empresa recebia ela mesma como acionista, ocorria uma Rerencia Circular, onde resolvi utilizando o WeakReference.
Dessa forma posso garantir que ela não se repetirá, pois ela guardará uma referencia dela mesma, que só é possível acessar através do seguinte código:
   WeakReference<Empresa> weakRef = empresa1.empresas.iterator().next();
        Empresa empresa = weakRef.get();

# Pendente
Refatoração da Classe EstruturaSocietariaService e EstruturaSocietariaServiceImpl

# bugs
Não está totalizando o valor da Empresa quando ela é acionista de outra Empresa (Resolvido)

# Para validação de testes
mvn test

# Prova Prática Java – v4
No Banco XPTO, para o cálculo do comprometimento financeiro de uma empresa, leva-se em 
conta o total de bens imóveis desta empresa e de seus sócios. Escreva um método (e todas as classes 
adicionais) para retornar o total do comprometimento financeiro de uma empresa, passando como 
parâmetro a sua estrutura societária. 

# Requisitos de Negócio:
- A estrutura societária de uma empresa é sempre composta por ao menos uma pessoa física
ou jurídica e pode ser composta por mais pessoas físicas e/ou jurídicas.
- Toda empresa possui uma estrutura societária.
- Pode haver ciclo societário, ou seja, a empresa A pode ser sócia da empresa B e a empresa B 
pode vir a ser sócia da empresa A. Inclusive, a empresa A pode vir a ser sócia dela mesma.
Além disso, qualquer pessoa física ou jurídica pode ser sócia de mais de uma empresa.
- A contabilização dos bens imóveis de uma pessoa (física ou jurídica) só deve ocorrer uma única 
vez.

# Requisitos Técnicos:
- Crie seu projeto utilizando algum gerenciador de dependências (ex: Maven) de maneira a 
independer de qualquer IDE.
- Valide a consistência de todas suas entradas (ex: CPF/CNPJ) e instancie todos seus objetos em 
estado consistente.
- Verifique com muito cuidado se seu programa não corre o risco de entrar em loop infinito
para nenhum caso de estrutura societária. Este será um dos principais pontos avaliados.
- Não se preocupe em utilizar frameworks de desenvolvimento web ou realizar persistências 
em bases de dados. As estruturas de dados e os algoritmos utilizados são mais relevantes.

# Sugestões:
- Escreva seu código utilizando todos os padrões no qual você possui conhecimento.
- Caso queira, pode utilizar a biblioteca Lombok para os seus POJOs.
- Comente os trechos de código quando achar conveniente. Lembre-se que futuramente, 
outras pessoas poderão dar manutenção nele.
- Seu código será avaliado pela funcionalidade, clareza e otimização.
- Você pode criar uma aplicação no estilo "Java Console Application"
