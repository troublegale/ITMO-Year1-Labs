import re

test_str = ['Сколько ты знаешь волшебных слов? Я вот знаю "Спасибо", "Алохомора" и "Э!".',
            'Хорошая работа, monsieur Olegue.',
            'Грязь, страшная грязь, облезлая гряз-з-зь, никому не нужная грязь...',
            'Ты просто не умеешь веселиться. Смотри: Е-Е-Е-Е-Е, движ! ЙО-О-О-О, круть! ИИИ-ХААА, отвисаем!',
            'Он мчал на своём Харлее. "Scheisse, моя милая фрау уже заждалась!"']

pattern = r'\b\w*\-?(?:[euioaуеыаоиюя]{2}|[euioaуеыаоиюя]\-[euioaуеыаоиюя])\-?\w*\b'
cons_pattern = r'[qwrtypsdfghjklzxcvbnmйцкнгшщзхфвпрлджчсмтб]'

for i in range(len(test_str)):
    current_str = test_str[i]
    current_words = current_str.split()
    current_answer = []
    for j in range(len(current_words) - 1):
        if re.search(pattern, current_words[j], flags=re.IGNORECASE) and \
                len(re.findall(cons_pattern, current_words[j + 1], flags=re.IGNORECASE)) <= 3:
            current_answer.append(re.findall(r'\b(?:\w*\-?)+\w*\b', current_words[j])[0])

    final_answer = ''
    if not current_answer:
        final_answer = 'Слов не нашлось!'
    else:
        for k in range(len(current_answer)):
            final_answer += current_answer[k]
            if k == len(current_answer) - 1:
                final_answer += '.'
            else:
                final_answer += ', '
    print(f'Подходящие слова для теста №{i + 1}: ', final_answer)
