import hashlib
import time


class Block:

    def __init__(self, index, data, previous_hash):
        self.index = index
        self.timestamp = time.time()
        self.data = data
        self.previous_hash = previous_hash
        self.nonce = 0
        self.hash = self.calculate_hash()

    def calculate_hash(self):
        contenido = (
            str(self.index) +
            str(self.timestamp) +
            str(self.data) +
            str(self.previous_hash) +
            str(self.nonce)
        )
        return hashlib.sha256(contenido.encode()).hexdigest()

    def mine_block(self, difficulty):
        objetivo = "0" * difficulty

        while self.hash[:difficulty] != objetivo:
            self.nonce += 1
            self.hash = self.calculate_hash()

        print("Bloque minado:", self.hash)