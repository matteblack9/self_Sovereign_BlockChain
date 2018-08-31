from iconservice import *


class POST_Token(IconScoreBase):

    __USER_ADDRESS = 'user_address'
    __ISSUERS = 'issuers'

    def __init__(self, db: IconScoreDatabase) -> None:
        super().__init__(db)

        self.__users_address = DictDB(self.__USER_ADDRESS, db, value_type=str, depth=1) # default = 1
        self.__issuers = DictDB(self.__ISSUERS, db, value_type=str, depth=1) # default = 1

<<<<<<< HEAD
<<<<<<< HEAD

    def on_install(self, designator) -> None:
=======
    def on_install(self, designator, delivered) -> None:
>>>>>>> 9cfb1b16c98d0d72c870bab79e57332eacf6a317
        super().on_install()

        # self.__designator.set(designator)

        self.__designator = designator
<<<<<<< HEAD
=======

        self.__is_delivered = delivered
>>>>>>> 9cfb1b16c98d0d72c870bab79e57332eacf6a317

=======
    def on_install(self) -> None:
        super().on_install()

>>>>>>> 376dbf7becb7a41abd2b157dcccd575c1edf11b2
    def on_update(self) -> None:
        super().on_update()
    
    @external(readonly=True)
    def get_my_claims(self) -> str:
        claims = self.__get_array_of(str(self.msg.sender))
        for e in claims:
            print(e)
        return "get_my_claims"

    @external
    def add_claim(self, claim: str):
        print(claim)
        print(self.__get_array_of(str(self.msg.sender)).put(claim))

    def __get_array_of(self, address: str):
        return ArrayDB(address, self.db, value_type=str)

    @external
    def add_new_user(self, public_key: str):
        if self.__users_address[str(self.msg.sender)] == 0: # not existed
            self.__users_address[str(self.msg.sender)] = public_key
            return "OK"
        else:
<<<<<<< HEAD
            print(f'Error ')

        

    
=======
            return "FAILURE"

    @external
    def add_new_issuers(self, public_key: str):
        if self.__issuers[str(self.msg.sender)] == 0: # not existed
            self.__issuers[str(self.msg.sender)] = public_key
            return "OK"
        else:
            return "FAILURE"
>>>>>>> 376dbf7becb7a41abd2b157dcccd575c1edf11b2

    @external(readonly=True)
    def get_user_public_key(self, user_address):
        key = self.__users_address[str(user_address)]
        if key == 0:
            return "FAILURE"
        else:
            return key

    @external(readonly=True)
    def get_issuer_public_key(self, issuer_address):
        key = self.__issuers[str(issuer_address)]
        if key == 0:
            return "FAILURE"
        else:
            return key


