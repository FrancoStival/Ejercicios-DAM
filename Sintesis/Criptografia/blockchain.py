from block import Block

class Blockchain:

    def __init__(self):
        self.chain = [self.create_genesis_block()]
        self.difficulty = 3
        self.balances = {}  # diccionario: clave pública -> balance

    def create_genesis_block(self):
        return Block(0, "Genesis Block", "0")
    
    def create_user(self, public_key, initial_balance=1000):
        self.balances[public_key] = initial_balance

    def get_latest_block(self):
        return self.chain[-1]

    def add_block(self, new_block):

        if isinstance(new_block.data, list):
            for tx in new_block.data:
                if not tx.is_valid():
                    print("Transacción inválida detectada")
                    return
                sender = tx.sender_public_key
                if sender not in self.balances:
                    self.balances[sender] = 0
                if self.balances[sender] < tx.amount:
                    print("Saldo insuficiente para la transacción")
                    return

        # Aplicar transacciones
        if isinstance(new_block.data, list):
            for tx in new_block.data:
                sender = tx.sender_public_key
                receiver = tx.receiver
                self.balances[sender] -= tx.amount
                self.balances[receiver] = self.balances.get(receiver, 0) + tx.amount

        new_block.previous_hash = self.get_latest_block().hash
        new_block.mine_block(self.difficulty)
        self.chain.append(new_block)

    def is_chain_valid(self):

        for i in range(1, len(self.chain)):

            current = self.chain[i]
            previous = self.chain[i - 1]

            if current.hash != current.calculate_hash():
                return False

            if current.previous_hash != previous.hash:
                return False

        return True